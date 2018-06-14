package cn.edu.hqu.javaee.chapter4_2.controller.formEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {
	@Getter
	@Setter
	String userName;
	@Getter
	@Setter
	String password;

};
