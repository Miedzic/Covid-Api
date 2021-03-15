package com.example.SpringFirstProject.authorization;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
 public class AuthorizationFasadeTest {
    private String login;
    private String passwd;
    private int localServerPort;
    private RestTemplate restTemplate;

    public AuthorizationFasadeTest() {
    }

    @Test
    public void FindIfUserIsMadeProperlyInDatabase() {
        //given
        //act
        System.err.println("ASDFG");
        var url = String.format("http://localhost:%s/register?login=%s&passwd=%s", localServerPort,login,passwd);
        ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class);
        //assert

    }
}