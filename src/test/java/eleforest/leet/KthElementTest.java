package eleforest.leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KthElementTest {
    @Test
    void testKthEleBasic() {
        int [] arr1 = {2,7,11,5,6,4,8};
        Assertions.assertEquals(8, KthElement.kthEle(arr1, 2)); 
    }

    @Test
    void testKthElemMid(){
        int [] arr1 = {2,8,11,5,6,4,8};
        Assertions.assertEquals(8, KthElement.kthEle(arr1, 2));
    }

    @Test
    void testKthElemOutofIndex(){
        int [] arr1 = {2,8,11,5,6,4,8};
        Assertions.assertThrows(IllegalArgumentException.class, 
                                () -> {KthElement.kthEle(arr1, 12);});
    }
}
