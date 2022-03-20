package com.example.songr;

import com.example.songr.domain.Album;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
		Album test = new Album("One", "Maher Zain", 15, 47.16, "https://pbs.twimg.com/media/Cj9cwB1WUAAXGp5?format=jpg&name=medium");
		test.setTitle("Rackat");
		assertEquals("Rackat",test.getTitle());
		assertEquals("Maher Zain",test.getArtist());
		assertEquals(15,test.getSongCount());
		assertEquals(47.16 , test.getLength());

	}

}
