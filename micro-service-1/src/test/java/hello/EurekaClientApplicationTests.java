//package hello;
//
//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * @author Marcin Grzejszczak
// */
//@RunWith(SpringRunner.class)
////@SpringBootTest(classes = EurekaClientApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
////@ActiveProfiles("test")
//public class EurekaClientApplicationTests {
////
////    static ConfigurableApplicationContext eurekaServer;
////
////    @BeforeClass
////    public static void startEureka() {
////        eurekaServer = SpringApplication.run(EurekaServer.class,
////                "--server.port=8761",
////                "--eureka.instance.leaseRenewalIntervalInSeconds=1");
////    }
////
////    @AfterClass
////    public static void closeEureka() {
////        eurekaServer.close();
////    }
////
////    @LocalServerPort
////    private int port;
////
////    @Autowired
////    private TestRestTemplate testRestTemplate;
////
////    @Test
////    public void shouldRegisterClientInEurekaServer() throws InterruptedException {
////        // registration has to take place...
////        Thread.sleep(3000);
////
////        ResponseEntity<String> response = this.testRestTemplate.getForEntity("http://localhost:" + this.port + "/service-instances/a-bootiful-client", String.class);
////
////        then(response.getStatusCode()).isEqualTo(HttpStatus.OK);
////        then(response.getBody()).contains("a-bootiful-client");
////    }
////
////    @Configuration
////    @EnableAutoConfiguration
////    @EnableEurekaServer
////    static class EurekaServer {
////    }
//}
