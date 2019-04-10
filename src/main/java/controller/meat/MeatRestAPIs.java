package com.project.rest.webservice.Project.controller.meat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import javax.persistence.criteria.CriteriaQuery;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.rest.webservice.Project.message.MeatCompanyForm;
import com.project.rest.webservice.Project.message.MeatProductForm;
import com.project.rest.webservice.Project.message.ProductOrderForm;
import com.project.rest.webservice.Project.model.User;
import com.project.rest.webservice.Project.model.UserRepository;
import com.project.rest.webservice.Project.model.Meat.Company;
import com.project.rest.webservice.Project.model.Meat.CompanyRepository;
import com.project.rest.webservice.Project.model.Meat.Order;
import com.project.rest.webservice.Project.model.Meat.OrderRepository;
import com.project.rest.webservice.Project.model.Meat.Product;
import com.project.rest.webservice.Project.model.Meat.ProductOrder;
import com.project.rest.webservice.Project.model.Meat.ProductOrderRepository;
import com.project.rest.webservice.Project.model.Meat.ProductRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MeatRestAPIs {

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ProductOrderRepository productOrderRepository;
	
	@Autowired
	UserRepository userRepository;

	// get all meat companies
	@GetMapping("/meats")
	public List<Company> getCompany() {
		return companyRepository.findAll();
	}

	// get meat company by id
	@GetMapping("/meats/{companyId}")
	public Optional<Company> getCompany(@PathVariable(value = "companyId") Long companyId) {
		return companyRepository.findById(companyId);
	}

	// create a meat company
	@PostMapping("/meats")
	public Company createCompany(@Valid @RequestBody MeatCompanyForm company) {

		Company comp = new Company(company.getName(), company.getEmail());
		companyRepository.save(comp);
		return comp;
	}

	// get all products
		@GetMapping("/products")
		public List<Product> getProducts() {
			return productRepository.findAll();
		}
		
	// get products by name
	@GetMapping("/product/{name}")
	public Optional<Product> getProductByName(@PathVariable(value = "name") String name) {
		return productRepository.findByName(name);
	}

	// get products by id
	@GetMapping("/product/{id}")
	public Optional<Product> getProductByID(@PathVariable(value = "id") Long id) {
		return productRepository.findById(id);
	}

	// get products by companyId
	@GetMapping("meats/products/{companyID}")
	public List<Product> getProducts(@PathVariable(value = "companyID") Long companyID) {
		return productRepository.findByCompanyID(companyID);
	}

	// create meat product with company id
	@PostMapping("/meats/product/{companyId}")
	public Product createProd(@PathVariable(value = "companyId") Long companyId,
			@Valid @RequestBody MeatProductForm product) {

		Product p = new Product(product.getName(), product.getCost());
		p.setCompanyId(companyId);
		productRepository.save(p);
		return p;
	}
	
//	@GetMapping("test/{productID}")
//	public Optional<Product> Test(@PathVariable(value = "productID") Long productID, @Valid @RequestBody MeatProductForm p) {
//		
//		Product pr = productRepository.findById(productID);
//		pr.
//		
//	}
//	p.setOrder(orderRepository.findById(orderId));
//	p.setProduct(productRepository.findById(productId));
	
	@GetMapping("/getProductOrder")
	public List<ProductOrder> getProdOrder(){
		 return productOrderRepository.findAll();
	}
	
	@GetMapping("/findProductOrder/{id}")
	public ProductOrder findProdOrder(@PathVariable (value="id") Long id){
		Optional<ProductOrder> stock = productOrderRepository.findById(id);
		return stock.get();
	}

	
	@GetMapping("/findProductsOrdered/{orderId}")
	public List<ProductOrder> findProductsOrder(@PathVariable (value="orderId") Long orderId){
		return productOrderRepository.findByOrderId(orderId);
		
	}
	
	@PostMapping("meats/productorder/{orderId}")
	public ProductOrder createProdOrder(@PathVariable (value = "orderId") Long orderId,
			@Valid @RequestBody ProductOrderForm productOrder) {
		
		Optional<Order> o = orderRepository.findById(orderId);
		Order order = o.get();
		
		Optional<Product> prod = productRepository.findById(productOrder.getTesterID());
		Product product = prod.get();
		
		ProductOrder p = new ProductOrder(productOrder.getQuantity());
		
		productOrder.setOrder(order);
		p.setOrder(productOrder.getOrder());
		p.getOrderID();
		
		productOrder.setProduct(product);
		p.setProduct(productOrder.getProduct());
		p.getProductID();
		p.getProductName();
		
		BigDecimal cost;
		productOrder.setProduct(product);
		cost = productOrder.getProduct().getProductCost().multiply(new BigDecimal(p.getQuantity()));
		productOrder.setCost(cost);
		p.setCost(productOrder.getCost());
		p.getCost();
		
		productOrderRepository.save(p);
		return p;
	}
	
	@PostMapping("/addOrder/{userId}")
	public Long createOrder(@PathVariable (value = "userId") Long userId) {
		Order o = new Order(userId);
		orderRepository.save(o);
		return o.getID();
	}
	@GetMapping("/getOrder/{orderId}")
	public Order getOrder(@PathVariable (value = "orderId") Long orderId){
		Optional<Order> o = orderRepository.findById(orderId);
		return o.get();
	}
	@GetMapping("/getOrders")
	public List<Order>getOrder(){
		return orderRepository.findAll();
	}
	@GetMapping("/getOrderIds/{userID}")
	public List<Long> getOrderIDs(@PathVariable (value = "userID") Long userID) {
		List<Order> order = orderRepository.findByUserID(userID);
		List<Long> orderIDs = new ArrayList<>();
		for(Order o : order) {
			orderIDs.add(o.getID());
		}
		return orderIDs;
	}	
//	@GetMapping("/getOrders/{userID}")
//	public List<Order> getOrdersByUesr(@PathVariable (value = "userID") Long userID){
//		List<Order> order = orderRepository.findByUserID(userID);
//		
//	}
	
	@GetMapping("/getUserId/{username}")
	public Long getUserID(@PathVariable (value = "username") String username) {
		Optional<User> user = userRepository.findByUsername(username);
		return user.get().getId();
	}
	
	@GetMapping("/getUsersId")
	public List<User> getUserID() {
		return userRepository.findAll();
	}

	
}
