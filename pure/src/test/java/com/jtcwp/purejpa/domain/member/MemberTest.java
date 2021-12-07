package com.jtcwp.purejpa.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("Member 도메인 테스트")
@SpringBootTest
class MemberTest {

    @Value("${persistence.unitname}")
    private String persistenceUnitName;

    @DisplayName("Member 등록 테스트")
    @Test
    void createMemberTable() throws Exception {
        // given
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // when
        Member member = new Member();
        member.setId(1L);
        member.setUserName("Jungho");
        em.persist(member);
        em.close();
        emf.close();
        tx.commit();

        // then
    }

}