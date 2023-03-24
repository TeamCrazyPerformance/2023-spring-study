package org.example.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DataInfoTest {

    @Test
    void testToString() {
        //given
        DataInfo dataInfo = new DataInfo("데이터1,1,1");
        //when
        String toString = dataInfo.toString();
        //then
        assertEquals("데이터1(TYPE_1)", toString);
        /*toString()에서 사이즈를 포함한 데이터까지 문자열로 변환하여 출력 하지 않았기에 getDataSize를 여기서 한번에 테스트하였음*/
        assertEquals(1, dataInfo.getDataSize());
    }
}
