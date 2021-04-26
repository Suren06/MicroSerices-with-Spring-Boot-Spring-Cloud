package com.ssm.user.service;

import com.ssm.user.VO.Department;
import com.ssm.user.VO.ResponseTemplateVO;
import com.ssm.user.entity.User;
import com.ssm.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findByUserId(Long userId){
        return userRepository.findByUserId(userId);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {

        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject
                ("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);

        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);

        return responseTemplateVO;
    }
}
