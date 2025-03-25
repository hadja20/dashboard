<script>
  import axios from "axios";
  import { Link } from "svelte-navigator";
  const register = async () => {
    await axios
      .post("http://localhost:8081/api/register", {
        username: username,
        email: email,
        password: password,
      })
      .then((res) => console.log(res))
      .catch((error) => console.log(error));
  };
  let username = "";
  let email = "";
  let password = "";
</script>

<main>
  <div class="register_form_wrapper">
    <div class="container">
      <div class="row">
        <div class="col-md-8 col-md-offset-2">
          <div class="register_wrapper">
            <div class="formsix-e">
              <div class="form-group i-password">
                <input
                  type="text"
                  class="form-control"
                  required=""
                  id="username"
                  placeholder="Username *"
                  bind:value={username}
                />
              </div>
            </div>

            <div class="formsix-pos">
              <div class="form-group i-email">
                <input
                  type="email"
                  class="form-control"
                  required=""
                  id="email2"
                  placeholder="Email Address *"
                  bind:value={email}
                />
              </div>
            </div>
            <div class="formsix-e">
              <div class="form-group i-password">
                <input
                  type="password"
                  class="form-control"
                  required=""
                  id="password2"
                  placeholder="Password *"
                  bind:value={password}
                />
              </div>
            </div>

            <div class="register_btn_wrapper">
              <a
                href="#"
                class="btn btn-primary register_btn"
                on:click|preventDefault={(e) => register()}
              >
                register
              </a>
            </div>
            <div class="register_message">
              <p>
                Already have an account ?
                <Link to="/login">Sign in</Link>
              </p>
            </div>
          </div>
        </div>
      </div>
      <div>
        <label for="email">Adresse e-mail</label><br>
        <input type="text" id="signup-email" name="email" placeholder="Adresse e-mail"  bind:value={email}>
      </div>
      <div>
        <label for="password">Mot de passe</label><br>
        <input type="password" id="signup-password" name="password" placeholder="Mot de passe"  bind:value={password}>
      </div>
        <label for="check"> <input type="checkbox" name="check" style="width:6%"> Afficher mot de passe</label>
      <div>
      <button type="submit" class="btn-primary" style="width: 100%; margin: 9px 0px; padding: 12px"><strong>S'inscrire</strong></button>
      </div>
      <div class="line" style="width: 40%; margin: 11px auto; margin-bottom: 39px;">
        <span style="font-size: 25px; background-color: white; padding: 0 10px; font-family: ui-rounded;">Or </span>
      </div>
          <div class="flash flash-success alert alert-dismissible fade show" role="alert" style="border: 2px solid #8628be54">
            <a href="http://localhost" data-bs-dismiss="alert" aria-label="Close">
              <i class="fab fa-google"></i>
            </a>
            <span>S'inscrire avec Google</span>
          </div>
          <div class="flash flash-success alert alert-dismissible fade show" role="alert" style="border: 2px solid #8628be54">
            <a href="http://localhost" data-bs-dismiss="alert" aria-label="Close">
              <i class="fab fa-facebook"></i>
            </a>
            <span>S'inscrire avec Google</span>
          </div>
          <div class="flash flash-success alert alert-dismissible fade show" role="alert" style="border: 2px solid #8628be54">
            <a href="http://localhost" data-bs-dismiss="alert" aria-label="Close">
              <i class="fab fa-twitter"></i>
            </a>
            <span>S'inscrire avec Google</span>
          </div>
    <button on:click|preventDefault={() => test()}></button>
  </div>
</main>

<style>
  .row {
    justify-content: center;
  }
  .register_form_wrapper {
    float: left;
    width: 100%;
    padding-top: 40px;
    padding-bottom: 100px;
  }

  .register_wrapper {
    padding-bottom: 20px;
    margin-bottom: 20px;
    border-bottom: 1px solid #e4e4e4;
    float: left;
    width: 100%;
    background: #fff;
    padding: 50px;
  }

  .register_wrapper a.btn {
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

  .register_wrapper .formsix-pos,
  .formsix-e {
    position: relative;
  }

  .form-group {
    margin-bottom: 15px;
  }

  .register_wrapper .form-control {
    height: 53px;
    padding: 15px 20px;
    font-size: 14px;
    line-height: 24px;
    border: 1px solid #fafafa;
    border-radius: 3px;
    box-shadow: none;
    font-family: "Roboto";
    -webkit-transition: all 0.3s ease 0s;
    -moz-transition: all 0.3s ease 0s;
    -o-transition: all 0.3s ease 0s;
    transition: all 0.3s ease 0s;
    background-color: #fafafa;
  }

  .register_wrapper .form-control:focus {
    color: #999;
    background-color: fafafa;
    border: 1px solid #4285f4 !important;
  }

  .register_btn_wrapper {
    padding-bottom: 20px;
    margin-bottom: 30px;
    border-bottom: 1px solid #e4e4e4;
  }

  .register_btn_wrapper a.register_btn {
    text-align: center;
    text-transform: uppercase;
  }

  .register_message p {
    text-align: center;
    font-size: 16px;
    margin: 0;
  }

  p {
    color: #999999;
    font-size: 14px;
    line-height: 24px;
  }

.form-control {
  border: 1px solid #57557a;
  border-radius: 3px;
  background: #212042;
  margin-bottom: 20px;
  letter-spacing: 1px;
}
.form-control:focus {
  border: 1px solid #57557a;
  border-radius: 3px;
  box-shadow: none;
  background: #212042;
  color: #fff;
  letter-spacing: 1px;
}
.btn-primary {
  background: linear-gradient(
      135deg,
      rgba(176, 106, 252, 1) 39%,
      rgba(116, 17, 255, 1) 101%
  );
  border: none;
  border-radius: 50px;
}
.btn-primary:focus {
  box-shadow: none;
  border: none;
}

.flash {
  padding: 16px 24px;
  display: flex;
  align-items: center;
  background: white;
  box-shadow: 0 0 8px rgba(0,0,0,0.2);
  border-radius: 4px;
}
.flash-success {
  border: 2px solid #1EDD88;
}
/* .flash-warning {
  border: 2px solid #FFC65A;
}
.flash-danger {
  border: 2px solid #FD1015;
} */
.line{
  height: 20px;
  border-bottom: 1px solid black;
  text-align: center;
  margin-bottom: 26px
}

input {
  padding:10px;
  border:0;
  box-shadow:0 0 15px 4px rgba(0,0,0,0.06);
  width: 100%;
  margin: 14px 0px;
  margin: 14px 0px !important;
}

.card-name{
  width: 100%;
}

  .register_wrapper a.btn:hover {
    background-color: #2c6ad4;
    border-color: #2c6ad4;
  }
</style>
