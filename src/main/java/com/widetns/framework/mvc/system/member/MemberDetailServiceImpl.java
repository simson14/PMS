package com.widetns.framework.mvc.system.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberDetailServiceImpl implements UserDetailsService {

    @Autowired
    MemberRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        MemberEntity member = repository.findByUserId(userId);

        if (member == null) {
            throw new UsernameNotFoundException(userId);
        }
        return new User(member.getUserId(), member.getUserPwd(), AuthorityUtils.createAuthorityList("USER"));
    }

}
