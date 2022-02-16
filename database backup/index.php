
<?php
    
    require_once 'user.php';
    $email = "";
    $password = "";   
    $fullname = "";
    $age = "";
    $address = "";
    $phone = "";
   
     if(isset($_POST['email'])){
        
        $email = $_POST['email'];
        
    }
    
    if(isset($_POST['password'])){
        
        $password = $_POST['password'];
        
    }
    if(isset($_POST['fullname'])){
        
        $fullname = $_POST['fullname'];
        
    }

    if(isset($_POST['age'])){
        
        $age = (int)$_POST['age'];
        
    }
    
    if(isset($_POST['address'])){
        
        $address = $_POST['address'];
        
    }
    if(isset($_POST['phone'])){
        
        $phone = (int)$_POST['phone'];
        
    }
   
    
   
    
    $userObject = new User();
    
   
    if(!empty($email) && !empty($password) && !empty($fullname) && !empty($age) &&  !empty($address) && !empty($phone)){
        
       $hashed_password = md5($password);
        
        $json_registration = $userObject->createNewRegisterUser( $email, $hashed_password, $fullname, $age, $address, $phone);
        
        echo json_encode($json_registration);
        
    }
    
    
    if(!empty($email) && !empty($password)){
        
         $hashed_password = md5($password);
          
        $json_array = $userObject->loginUsers($email, $hashed_password);
      
        echo json_encode($json_array);
    
        
    }
    ?>