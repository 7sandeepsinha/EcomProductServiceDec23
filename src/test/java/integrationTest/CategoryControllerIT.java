package integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.sandeep.EcomProductServiceDec23.EcomProductServiceDec23Application;
import dev.sandeep.EcomProductServiceDec23.entity.Category;
import dev.sandeep.EcomProductServiceDec23.entity.Product;
import dev.sandeep.EcomProductServiceDec23.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EcomProductServiceDec23Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class CategoryControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testGetTotalPriceForAllProducts() throws Exception {
        // Given
        Category category = new Category();
        category.setId(UUID.randomUUID());
        category.setName("Test Category");

        Product product1 = new Product();
        product1.setId(UUID.randomUUID());
        product1.setTitle("Product 1");
        product1.setPrice(50.0);

        Product product2 = new Product();
        product2.setId(UUID.randomUUID());
        product2.setTitle("Product 2");
        product2.setPrice(75.0);

        category.setProducts(Arrays.asList(product1, product2));

        categoryRepository.save(category);

        // When
        MvcResult result = mockMvc.perform(get("/category/totalPrice/{categoryId}", category.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Then
        double responseTotalPrice = Double.parseDouble(result.getResponse().getContentAsString());
        Assertions.assertEquals(125.0, responseTotalPrice, 0.01);
    }
}
