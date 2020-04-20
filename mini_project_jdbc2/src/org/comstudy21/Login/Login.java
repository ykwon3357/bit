package org.comstudy21.Login;
import static org.comstudy21.resource.R.listController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.comstudy21.resource.R;
import org.comstudy21.view.MainFrame;
import org.comstudy21.view.SubFrame;

public class Login extends JFrame implements R{

	private JPanel contentPane;
	private JTextField txtId;
	private JPasswordField txtPw;

	private String sID = "";
	private String sPW = "";

	public Login() {
		setTitle("고객 관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 164);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(40, 30, 47, 15);
		contentPane.add(lblId);

		txtId = new JTextField();
		txtId.setText("");
		// sID = txtId.getText();
		txtId.setBounds(99, 27, 167, 21);
		contentPane.add(txtId);
		txtId.setColumns(10);

		JLabel lblPw = new JLabel("PW");
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblPw.setBounds(40, 55, 47, 15);
		contentPane.add(lblPw);

		txtPw = new JPasswordField();
		txtPw.setText("");
		// sPW = txtId.getText();
		txtPw.setBounds(99, 52, 167, 21);
		contentPane.add(txtPw);
		txtPw.setColumns(10);

		JButton btnNewButton_Login = new JButton("로그인");
		btnNewButton_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 로그인 했을 때 작업
				boolean bLoginChk = false;
				GetIdandPw(txtId, txtPw); // 입력된 값 각각 넘겨 주기
				bLoginChk = daoUser.LogInList_Chk(sID, sPW); // false면 로그인 실패

				if (!bLoginChk) { // 로그인 실패
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 확인 후\n다시 로그인해주세요.");
				} else { // 로그인 성공
					login.setVisible(false);
					setVisible(false); // 기존의 로그인 화면 꺼주기
					new MainFrame();
					listController.service();
					//LoginMain.bLogInStatus = true;// 로그인 성공이면 상태변환 및 로그인 버튼 수정
					//LoginMain.bookmain.Login(); // 화면 갱신
				}
				// 이곳에 새로운 화면 구현
			}
		});
		btnNewButton_Login.setBounds(274, 27, 102, 46);
		contentPane.add(btnNewButton_Login);

		JButton btnNewButton_Sign = new JButton("회원 가입");
		btnNewButton_Sign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// // 회원가입 했을 때 작업
				// LoginMain.login.setVisible(false); // 기존의 로그인 화면 꺼주기

				join.setVisible(true); // 회원 가입 화면 켜주기
			}
		});
		btnNewButton_Sign.setBounds(274, 80, 102, 30);
		contentPane.add(btnNewButton_Sign);

		JButton button_FindID = new JButton("ID 찾기");
		button_FindID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ID찾기 했을 때 작업
				// LoginMain.login.setVisible(false); // 로그인 화면 off
				findId.setVisible(true);
			}
		});
		button_FindID.setBounds(40, 80, 109, 30);
		contentPane.add(button_FindID);

		JButton button_Findepw = new JButton("PW찾기");
		button_Findepw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// PW찾기 했을 때 작업
				// LoginMain.login.setVisible(false); // 로그인 화면 off
				findpw.setVisible(true);
			}
		});
		button_Findepw.setBounds(152, 80, 118, 30);
		contentPane.add(button_Findepw);

		JButton button = new JButton("게스트 입장");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); // 기존의 로그인 화면 꺼주기
				new SubFrame();
				listController.service();
			}
		});
		button.setBounds(388, 26, 102, 84);
		contentPane.add(button);

		Reset(txtId, txtPw);
		setVisible(true);
	}
	public static void ShowMessage(String str) {
		JOptionPane.showMessageDialog(null, str);
	}

	private void GetIdandPw(JTextField txtId, JTextField txtPw) {
		sID = txtId.getText();
		sPW = txtPw.getText();
	}

	private void Reset(JTextField txtId, JTextField txtPw) {
		txtId.setText(null);
		txtPw.setText(null);
	}
}