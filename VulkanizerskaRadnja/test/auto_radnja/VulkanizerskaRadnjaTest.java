package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VulkanizerskaRadnjaTest extends RadnjaTest {


	public Radnja getInstance() {
		return new VulkanizerskaRadnja();
	}

}
