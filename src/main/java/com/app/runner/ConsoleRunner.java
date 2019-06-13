package com.app.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repo.ProductRepository;
@Component
public class ConsoleRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;

	public void run(String... args) throws Exception {
		repo.save(new Product(31,"E",4.1));
		repo.save(new Product(32,"F",4.2));
		repo.save(new Product(33,"G",4.2));
		repo.save(new Product(34,"H",4.2));

		repo.save(new Product(35,"I",4.5));
		repo.save(new Product(36,"J",4.6));
		repo.save(new Product(37,"K",4.7));
		repo.save(new Product(38,"L",4.8));


		/*
		 * //(i)findAll()---- FETCH ALL RECORD IN DATABASES List<Product> list=repo.findAll();
		 * list.forEach(System.out::println);
		 */ 

		/* //(ii)findAll(Sort)--------FIND ORDER-----//---1--ex---2--ex
		 * repo.findAll(Sort.by(Direction.DESC,"prodCode")).forEach(System.out::println);;
		 */ 

		// repo.findAll(Sort.by("prodCost")).forEach(System.out::println);;//---2---ex

		//(iii)findAll(pageable)----- Pagination PageRequest PageRequest p=PageRequest.of(1,3);
		//repo.findAll(p).forEach(System.out::println);

		//(iv)(01)Example findAll(Example) method

		/*Product p=new Product();
		p.setProdCost(4.2);
		Example<Product> ex=Example.of(p);*/

		//(02)With Sorting

		/*Product p=new Product();
		p.setProdCost(4.2);
		Example<Product> ex=Example.of(p);
		repo.findAll(ex,Sort.by(Direction.DESC,"prodCode")).forEach(System.out::println);;*/


		//(03)With pagination
		/*
		 * Product p=new Product(); p.setProdCost(4.2); Example<Product>
		 * ex=Example.of(p);
		 * repo.findAll(ex,PageRequest.of(1,3)).forEach(System.out::println);;
		 */


		//(V)findAllById() in caluse

		repo.findAllById(Arrays.asList(31,32,33,34)).forEach(System.out::println);

	}

}
