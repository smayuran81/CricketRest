package com.myProject.Cricket.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Collections2;
import com.myProject.Cricket.Service.PrincipalService;
import com.myProject.Cricket.Service.RoleService;
import com.myProject.Cricket.model.Principal;
import com.myProject.Cricket.model.Role;


@Component
public class myUserDetailsService implements UserDetailsService {

	@Autowired
	private PrincipalService principalService;

	@Autowired
	private RoleService roleService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		final Principal principal = principalService.findByName(username);

		Set<Role> roles = principal.getRoles();

		Set<String> stringRolesSet = roles.stream().map(Role::getName).collect(Collectors.toSet());
		
		final Function<Object, String> toStringFunction = Functions.toStringFunction();
		
		final Collection<String> rolesToString = Collections2.transform(roles, toStringFunction);
		
		final String[] rolesStringArray = rolesToString.toArray(new String[rolesToString.size()]);

		return new User(principal.getName(), principal.getPassword(),
				AuthorityUtils.createAuthorityList(rolesStringArray));
	}

}
