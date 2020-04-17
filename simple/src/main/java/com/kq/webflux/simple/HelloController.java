package com.kq.webflux.simple;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String handle(String name) {
		return "Hello " + name;
	}

	@GetMapping("/products")
	public Flux<String> findAll() {
//		return restaurantRepository.findAll();

		Flux<String> flux = Flux.just("1","2","3");
		return flux;

	}


	@GetMapping("/products1")
	public Flux<Integer> findAll1() {
//		return restaurantRepository.findAll();

		Flux<Integer> ints = Flux.range(1, 4)
				.map(i -> {
					try {
						TimeUnit.SECONDS.sleep(3);
					}catch (Exception e){
						e.printStackTrace();
					}
					return i;
				});

		return ints;

	}

	/**
	 * call http://localhost:9000/products2
	 * @return
	 */
	@GetMapping("/products2")
	public Flux<String> findAll2() {
//		return restaurantRepository.findAll();

		Flux<String> flux =
				Flux.interval(Duration.ofSeconds(2))
						.map(input -> {
							if (input < 1000) {
								return "tick " + input;
							}
							throw new RuntimeException("boom");
						})
						.onErrorReturn("Uh oh");
		return flux;

	}

}