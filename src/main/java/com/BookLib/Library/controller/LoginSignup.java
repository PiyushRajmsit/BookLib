package com.BookLib.Library.controller;


import com.BookLib.Library.model.Members;
import com.BookLib.Library.repository.Constants;
import com.BookLib.Library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("")
public class LoginSignup {

    @Autowired
    MemberRepository memberRepository;


    @PostMapping("/signup")
    public String Signup(@Valid @RequestBody Members member) throws Exception{

        Members newMember = memberRepository.findname(member.getEmail());

        if(newMember != null){
            return "Member Already Exists";
        }
        member.setMoneyFunds(Constants.NEW_USER_MONEY_FUNDS);
        memberRepository.save(member);
        return "Member Created Successfully";
    }

    @PostMapping("/login/{mail}/{pwd}")
    public String Login(@Valid @PathVariable(value = "mail")String email,@Valid @PathVariable(value = "pwd")String password)
            throws Exception{
        Members members = memberRepository.findname(email);
        if(members != null)
        {
            if(members.getPassword() != password)
            {
                return "Wrong Email/Password";
            }

            return "Successfull Login";
        }

        return "Wrong Email/Password";
    }

}
