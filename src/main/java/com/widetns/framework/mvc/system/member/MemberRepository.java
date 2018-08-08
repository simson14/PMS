package com.widetns.framework.mvc.system.member;

import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<MemberEntity, Long> {

    public MemberEntity findByUserId(String userId);
}
