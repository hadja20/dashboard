<script>
    import axios from "axios"
    import {token} from "../store/auth"
    import {Link} from "svelte-navigator"

    let email = "",
        password = "";

    const saveToken = (user, token) => {
        sessionStorage.setItem('token', JSON.stringify(token));
        sessionStorage.setItem('user', JSON.stringify(user));        
        token=token
    }

    const submit = async () => {
        await axios
            .post("http://localhost:8081/api/login",{
                "email":email,
                "password":password
            })
            .then((response)=>{
            saveToken(response.data, response.data.accessToken)
            token.set(response.data.accessToken)
         })
            .catch((error) => {
              console.log(error)                
            });
    };

</script>

<main>
    <div class="container">
        <div class="row d-flex justify-content-center mt-5">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card py-3 px-2">
                    <p class="text-center mb-3 mt-2">SE CONNECTER AVEC</p>
                    <div class="row mx-auto ">
                        <div class="col-4">
                            <i class="fab fa-twitter" />
                        </div>
                        <div class="col-4">
                            <i class="fab fa-facebook" />
                        </div>
                        <a class="col-4" href="http://localhost:8081/oauth2/authorization/google">
                            <i class="fab fa-google" />
                        </a>
                    </div>
                    <div class="division">
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-xs-12 col-sm-6">
                                <a href="#" class="btn btn-primary facebook"> <span>Login with Facebook</span> <i class="fa fa-facebook"></i> </a>
                            </div>
                            <div class="col-lg-6 col-md-6 col-xs-12 col-sm-6">
                                <a href="#" class="btn btn-primary google-plus"> Login  with Google <i class="fa fa-google-plus"></i> </a>
                            </div>
                        </div>
                        <h2>or</h2>
                        <div class="formsix-pos">
                            <div class="form-group i-email">
                                <input type="email" class="form-control" required="" id="email2" placeholder="Email Address *" bind:value={email}>
                            </div>
                        </div>
                        <div class="formsix-e">
                            <div class="form-group i-password">
                                <input type="password" class="form-control" required="" id="password2" placeholder="Password *"bind:value={password}>
                            </div>
                        </div>
                      
                        <div class="login_btn_wrapper">
                            <a href="#" class="btn btn-primary login_btn" on:click|preventDefault={e=>submit()}> Login </a>
                        </div>
                        <div class="login_message">
                            <p>Don&rsquo;t have an account ? 
                                <Link to="/register">Sign up</Link></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
 
</main>

<style>

    .row{
        justify-content: center;
    }
.login_form_wrapper {
    float: left;
    width: 100%;
    padding-top: 40px;
    padding-bottom: 100px;
}

.login_wrapper {
    padding-bottom: 20px;
    margin-bottom: 20px;
    border-bottom: 1px solid #e4e4e4;
    float: left;
    width: 100%;
    background: #fff;
    padding: 50px;
}

.login_wrapper a.btn {
    color: #fff;
    width: 100%;
    height: 50px;
    padding: 6px 25px;
    line-height: 36px;
    margin-bottom: 20px;
    text-align: left;
    border-radius: 5px;
    background: #4385f5;
    font-size: 16px;
    border: 1px solid #4385f5;
}


.login_wrapper a i {
    float: right;
    margin: 0;
    line-height: 35px;
}

.login_wrapper a.google-plus {
    background: #db4c3e;
    border: 1px solid #db4c3e;
}

.login_wrapper h2 {
    font-size: 18px;
    font-weight: 500;
    margin-bottom: 20px;
    color: #111;
    line-height: 20px;
    text-transform: uppercase;
    text-align: center;
    position: relative;
}

.login_wrapper .formsix-pos, .formsix-e {
    position: relative;
}

.form-group {
    margin-bottom: 15px;
}

.login_wrapper .form-control {
    height: 53px;
    padding: 15px 20px;
    font-size: 14px;
    line-height: 24px;
    border: 1px solid #fafafa;
    border-radius: 3px;
    box-shadow: none;
    font-family: 'Roboto';
    -webkit-transition: all 0.3s ease 0s;
    -moz-transition: all 0.3s ease 0s;
    -o-transition: all 0.3s ease 0s;
    transition: all 0.3s ease 0s;
    background-color: #fafafa;
}

.login_wrapper .form-control:focus {
    color: #999;
    background-color: fafafa;
    border: 1px solid #4285f4 !important;
}



.login_btn_wrapper {
    padding-bottom: 20px;
    margin-bottom: 30px;
    border-bottom: 1px solid #e4e4e4;
}

.login_btn_wrapper a.login_btn {
    text-align: center;
    text-transform: uppercase;
}

.login_message p {
    text-align: center;
    font-size: 16px;
    margin: 0;
}

p {
    color: #999999;
    font-size: 14px;
    line-height: 24px;
}

.login_wrapper a.login_btn:hover {
    background-color: #2c6ad4;
    border-color: #2c6ad4;
}

.login_wrapper a.btn:hover {
    background-color: #2c6ad4;
    border-color: #2c6ad4;
}

.login_wrapper a.google-plus:hover {
    background: #bd4033;
    border-color: #bd4033;
}

    
</style>
