package net.aptech.h3clothing.security;

import net.aptech.h3clothing.entity.User;
import net.aptech.h3clothing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository repository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = repository.loadUserByEmail(username).get();
        if(u == null){
            throw new UsernameNotFoundException("Email Not Found !");
        }
        return new CustomerUserDetail(u);
    }

    @Transactional
    public UserDetails loadUserById(Integer id) {
        User user = repository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return new CustomerUserDetail(user);
    }
}
