package com.example.core.order;

import com.example.core.member.Grade;
import com.example.core.member.Member;
import com.example.core.member.MemberService;
import com.example.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    // 구현체 객체를 직접 가져와서 사용
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        // given
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        // when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
       // then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
