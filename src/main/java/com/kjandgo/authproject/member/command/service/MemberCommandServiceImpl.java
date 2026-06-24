package com.kjandgo.authproject.member.command.service;

import com.kjandgo.authproject.member.command.dto.UserDetailInfoDTO;
import com.kjandgo.authproject.member.command.dto.UserImpl;
import com.kjandgo.authproject.member.command.entity.LoginHistory;
import com.kjandgo.authproject.member.command.entity.Member;
import com.kjandgo.authproject.member.command.repository.LoginHistoryCommandRepository;
import com.kjandgo.authproject.member.command.repository.MemberCommandRepository;
import com.kjandgo.authproject.member.query.service.MemberQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
public class MemberCommandServiceImpl implements MemberCommandService{
    private final MemberCommandRepository memberCommandRepository;
    private final LoginHistoryCommandRepository loginHistoryCommandRepository;
    private final MemberQueryService memberQueryService;

    public MemberCommandServiceImpl(LoginHistoryCommandRepository loginHistoryCommandRepository,
                                    MemberCommandRepository memberCommandRepository,
                                    MemberQueryService memberQueryService){
        this.loginHistoryCommandRepository = loginHistoryCommandRepository;
        this.memberCommandRepository = memberCommandRepository;
        this.memberQueryService = memberQueryService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberCommandRepository.findByUserName(username);

        // 존재하지 않는 아이디
        if (member == null) throw new UsernameNotFoundException("회원정보가 존재하지 않습니다.");

        // 정지된 회원
        if (member.getStatus() == 'Q') throw new LockedException("퇴사한 직원입니다.");

        // 5회 이상 로그인 시도


        // 회원 권한 꺼내기
        List<GrantedAuthority> grantedAuthorities = memberQueryService.getUserAuth(member.getId());


        // 커스텀한 User 객체 이용(원래는 안티 패턴)
        UserImpl userImpl = new UserImpl(member.getUserName(), member.getPassword(), grantedAuthorities);
        userImpl.setUserInfo(new UserDetailInfoDTO(
                        member.getId(),
                member.getUserName(),
                member.getPassword(),
                member.getName(),
                member.getEmail(),
                member.getSignUpDate(),
                member.getRecentLoginDate(),
                member.getStatus(),
                member.getProfileImage()
                )
        );

        return userImpl;
        // 사용자의 id,pw,권한,하위 정보들을 provider로 전송
//        return new User(employee.getEmpId(), employee.getPwd(), true, true, true, true, grantedAuthorities);
    }

    @Override
    @Transactional
    public void saveLoginHistory(Long id, String ipAddress, char y) {
        LoginHistory loginHistory = new LoginHistory();
        LocalDateTime now = LocalDateTime.now();
        loginHistory.setLoginTrialDate(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        loginHistory.setLoginIsSucceed(y+"");
        loginHistory.setLoginIp(ipAddress);
        loginHistory.setDescription(" ");
        loginHistory.setMemberId(id);
        loginHistoryCommandRepository.save(loginHistory);
    }


}
