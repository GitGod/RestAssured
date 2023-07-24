import com.fasterxml.jackson.annotation.JsonInclude;
import io.restassured.http.ContentType;
import model.Post;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class UpdatePostTest {
    @Test
    public void updatePost(){
        Map<String,Object> updatePost = new HashMap<>();
        updatePost.put("title","tytul po aktualizacji");
        updatePost.put("author","Daria");
        given().log().all().contentType(ContentType.JSON).body(updatePost)
                .when().put("http://localhost:3000/posts/1")
                .then().log().all();
    }
    @Test
    public void updatePostClass() {
        Post updatePost = new Post();
        updatePost.setTitle("Tytul obiektowy po aktualizacji");
       updatePost.setAuthor("Kacper");
        given().log().all().contentType(ContentType.JSON).body(updatePost)
                .when().put("http://localhost:3000/posts/1")
                .then().log().all();
    }
    @Test
    public void replacePostClass() {
        Post updatePost = new Post();
        updatePost.setTitle("Tytul obiektowy po aktualizacji");
        //  updatePost.setAuthor("Kacper");
        given().log().all().contentType(ContentType.JSON).body(updatePost)
                .when().patch("http://localhost:3000/posts/1")
                .then().log().all();
    }
}
