//package com.product.security.auth;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ApplicationUserService implements UserDetailsService {
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }
//
////    private final ApplicationUserDao applicationUserDao;
//
////    public ApplicationUserService(ApplicationUserDao applicationUserDao) {
////        this.applicationUserDao = applicationUserDao;
////    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return applicationUserDao.selectApplicationUserByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s not fount", username)));
//    }
//}
