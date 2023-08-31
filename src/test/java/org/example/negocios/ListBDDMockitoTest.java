package org.example.negocios;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class ListBDDMockitoTest {

    @Test
    void testandoListaComMockitoRetorna10() {

        //Given
        List  list = mock(List.class);

        when(list.size()).thenReturn(10);

        assertEquals(10,list.size());

    }
    @Test
    void testandoListaUsandoBDDMockito() {

        //Given
        List  list = mock(List.class);

        given(list.size()).willReturn(10);

        assertThat(list.size(), is(10));

    }
    @Test
    void testandoListaComBDDMockitoRetornaComGetList() {

        //Given
        var  list = mock(List.class);

        given(list.get(0)).willReturn("Leo");

        assertThat(list.get(0), is("Leo"));

    }

    @Test
    void testandoListaComMockitoRetornaComArgumentMatchers() {

        //Given
        var  list = mock(List.class);

        // È chamado de argumento matcher quando utiliza o ANY
        when(list.get(anyInt())).thenReturn("Leo");


        assertEquals("Leo",list.get(anyInt()));
        assertEquals("Leo",list.get(anyInt()));


    }
    @Test
    void testandoListaComMockitoRetornaComRuntimeException() {

        //Given
        var  list = mock(List.class);

        // È chamado de argumento matcher quando utiliza o ANY
        when(list.get(anyInt())).thenThrow(new RuntimeException("Foor bar"));

        assertThrows(RuntimeException.class, () -> {
           list.get(anyInt());
        }, () -> "Shoul have throw an RuntimeException");

    }

    @Test
    void testandoListaComBDDMockito() {

        //Given
        var  list = mock(List.class);

        // È chamado de argumento matcher quando utiliza o ANY
        when(list.get(anyInt())).thenThrow(new RuntimeException("Foor bar"));

        assertThrows(RuntimeException.class, () -> {
           list.get(anyInt());
        }, () -> "Shoul have throw an RuntimeException");

    }

}
