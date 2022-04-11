package com.example.empservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.empservice.dao.EmployeeRepository;
import com.example.empservice.dao.RoleRepository;
import com.example.empservice.dao.UserRepository;
import com.example.empservice.entity.Employee;
import com.example.empservice.entity.Role;
import com.example.empservice.entity.User;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	BCryptPasswordEncoder bcryptEncoder;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> res = employeeRepository.findById(theId);
		Employee theEmployee = null;
		if (res.isPresent()) {
			theEmployee = res.get();
		} else {
			throw new RuntimeException("Employee id not found : " + theId);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

	@Override
	public List<Employee> searchByFirstName(String firstName) {
		return employeeRepository.findByFirstNameContainsAllIgnoreCase(firstName);
	}

	@Override
	public List<Employee> sortByFirstName(String order) {
		if (order.equals("desc")) {
			return employeeRepository.findAllByOrderByFirstNameDesc();
		} else {
			return employeeRepository.findAllByOrderByFirstNameAsc();
		}
	}

	@Override
	public User saveUser(User user) {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}
}
