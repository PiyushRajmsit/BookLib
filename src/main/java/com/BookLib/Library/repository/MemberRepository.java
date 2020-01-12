package com.BookLib.Library.repository;

import com.BookLib.Library.model.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import java.lang.reflect.Member;

public interface MemberRepository extends JpaRepository<Members,Long> {
    Members findByEmail(String email);
}
