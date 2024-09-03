package br.com.cqrs.poc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CqrsAndEvetSourcePocApplicationTest {
    @Test
    public void testeMoc() {
        Assertions.assertEquals(1, 1);
    }
}