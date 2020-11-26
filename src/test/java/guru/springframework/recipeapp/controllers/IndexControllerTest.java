package guru.springframework.recipeapp.controllers;

import guru.springframework.recipeapp.services.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(IndexController.class)
class IndexControllerTest {

//   private IndexController indexController;

   @MockBean
   private RecipeService recipeService;

//   @MockBean
//   private Model model;

    @Autowired
    private MockMvc mockMvc;

//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//        indexController = new IndexController(recipeService);
//    }

    @Test
    void testMockMvc() throws Exception {

        this.mockMvc.perform(get("/")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

//    @Test
//    void getIndexPage() {
//
//        Recipe recipe1 = new Recipe();
//        recipe1.setId(1L);
//        Recipe recipe2 = new Recipe();
//        recipe2.setId(2L);
//
//        Set<Recipe> recipeSet = Set.of(recipe1, recipe2);
//
//        doReturn(recipeSet).when(recipeService).getRecipes();
//
//        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
//
//
//        String result = indexController.getIndexPage(model);
//;
//        verify(recipeService, times(1)).getRecipes();
//        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
//        assertEquals("index", result);
//
//        Set<Recipe> setInController = argumentCaptor.getValue();
//        assertEquals(recipeSet, setInController);
//    }
}