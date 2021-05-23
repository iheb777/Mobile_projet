<?php
	require_once 'connectdb.php';


                    $user = $_POST['user'];
					$password = $_POST['password']; 
					
                    $stmt = $conn->prepare("SELECT * FROM users WHERE user = ? AND password = ?");
 					$stmt->bind_param("ss",$user, $password);
					
					$stmt->execute();
					
					$stmt->store_result();
					
					if($stmt->num_rows > 0){
						
						$stmt->bind_result($id, $user, $email, $role);
						$stmt->fetch();
						
						$userdata = array(
							'id'=>$id, 
							'user'=>$user, 
							'email'=>$email,
							'role'=>$role
						);
						
						$response['error'] = false; 
						$response['message'] = 'Login successfull'; 
                        $response['userdata'] = $userdata; 
                        
                        echo json_encode($response);
                    }
                    else
                    {
						$response['error'] = false; 
                        $response['message'] = 'Invalid user or password';
                        echo json_encode($response);
                    }


                    

?>