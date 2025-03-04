import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void testUserCreation() {
        User user = new User();
        assertNotNull(user);
    }

    @Test
    void testUserGettersAndSetters() {
        User user = new User();
        Long id = 1L;
        String name = "John Doe";
        String address = "123 Main St";
        int age = 30;
        String phoneNumber = "555-1212";
        String password = "password123";

        user.setId(id);
        user.setName(name);
        user.setAddress(address);
        user.setAge(age);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);

        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(address, user.getAddress());
        assertEquals(age, user.getAge());
        assertEquals(phoneNumber, user.getPhoneNumber());
        assertEquals(password, user.getPassword());
    }

    @Test
    void testUserNullName() {
        User user = new User();
        user.setName(null);
        assertNull(user.getName());
    }

    @Test
    void testUserEmptyName() {
        User user = new User();
        user.setName("");
        assertEquals("", user.getName());
    }

    @Test
    void testUserWithLongName(){
        User user = new User();
        String longName = "a".repeat(256); //Simulate a long name.  Adjust length as needed.
        user.setName(longName);
        assertEquals(longName, user.getName());

    }

    @Test
    void testUserWithSpecialCharacters(){
        User user = new User();
        String nameWithSpecialChars = "John O'Malley !@#$%^&*()_+=-`~[]\{}|;':\",./<>?";
        user.setName(nameWithSpecialChars);
        assertEquals(nameWithSpecialChars, user.getName());
    }


    @Test
    void testUserNegativeAge(){
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setAge(-1)); //This should ideally throw an exception,  but the current code doesn't.  Add validation to the setter if needed.
    }


    @Test
    void testUserLargeAge(){
        User user = new User();
        user.setAge(150); //Testing edge case,  consider adding validation to the setter if needed.
        assertEquals(150, user.getAge());
    }


}
