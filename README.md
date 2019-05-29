# Spring-Ribbon-Server
Mohon jgn rancu dengan kata Server pada project name ini. Spring Ribbon Server hanyalah Client Micro Services biasa yang mendaftarkan dirinya sendiri ke Eureka. Untuk mengetes framwork ribbon, kita akan menjalankan beberapa instance service ini yang di bedakan dengan port

# Dependencies
Config Client</br>
Eureka Discovery</br>
Web</br>

# How to
1. Tambahkan @EnableDiscoveryClient pada SpringBootApplicationClass, dengan konfigurasi ini menandakan service ini ingin mendaftar dirinya pakan EurekaServer. Sebenarnya ada @EnableEurekaClient tapi kita tidak gunakan ini krn tidak semua server menggunakan eureka dan untuk amannya kita gunakan @EnableDiscoveryClient
```
@SpringBootApplication
@EnableDiscoveryClient
public class SpringEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaClientApplication.class, args);
	}
}
```
2. Build maven dengan executeable jar</br>
3. Agar instance dari service yang sama dapat berjalan, kita jalankan dengan operan parameter port yang berbeda :/br>
```
java -jar spring-ribbon-server.jar --server.port=9085
java -jar spring-ribbon-server.jar --server.port=9086
```
Bila kita lihat dashboard pada eureka, harapan kita adalah ada 2 instqance springRibbonServer yang berjalan di port 9085 dan 9086</br>
4. Server siap untuk menerima command
```
@RestController
public class SpringRibbonRest {

	@GetMapping("/fetch")
	public String fetch() {
		return "Fetched dari 9085";
	}
	
	@GetMapping("/feignGet/{nomor}")
	public Map<String, Object> feignGet(@PathVariable("nomor") Long nomor, @RequestParam("nama") String nama) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nomor ", nomor);
		map.put("nama ", nama);
		return map;
	}
	
	@PostMapping("/feignPost/{nomor}")
	public Map<String, Object> feignPost(@PathVariable("nomor") Long nomor, @RequestBody Map<String, Object> param) {
		param.put("Nomor", nomor);
		return param;
	}
}
```
5. Pada tahap server telah selesai. Karene sibbon merupan loadbalancer di sisi client, maka penentuan pemilihan instance server call di lakukan di sisi client</br>
