package be.jnn.training.pluralsight.resttemplate;

import be.jnn.training.pluralsight.resttemplate.controller.FriendController;
import be.jnn.training.pluralsight.resttemplate.model.Friend;
import be.jnn.training.pluralsight.resttemplate.repository.FriendRepository;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@RunWith(SpringRunner.class)
@WebMvcTest(FriendController.class)
public class StandAloneControllerTest {

    @MockBean
    FriendRepository friendRepository;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testCreateAndDelete() throws Exception {
        Friend friend = new Friend("Gordon", "Moore");

        List<Friend> friends = Arrays.asList(friend);

        Mockito.when(friendRepository.findAll()).thenReturn(friends);

        mockMvc.perform(get("/friend"))
                .andExpect(status().isOk())
                //Display the content of the perform get url
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                //---------WARNING : property name in jsonProperty annotation in the model
                //So that check "$[0].first-name" and not "$[0].firstName"
                //--------------------------------------------------------
                .andExpect(jsonPath("$[0].first-name", Matchers.is("Gordon")));
        ;
    }
}
