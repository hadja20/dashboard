<script>
    let src = "../../../images/weather.png";
    import {Link} from "svelte-navigator"
</script>

<main>
    <div class="containerm">
        <div class="row">
            <div class="col-md-4">
                <Link to="weather">   <div class="image"> <img src= "../../../images/weather.png" alt=""><i class="bi bi-arrow-right"></i></div> </Link>
            </div>
            <div class="col-md-4">
                <Link to="clock">   <div class="image"><img src= "../../../images/clock.jpg" alt=""> <i class="bi bi-arrow-right"></i></div></Link>
            </div>
            <div class="col-md-4">
                <Link to="quote">  <div class="image"> <img src= "../../../images/quote.jpg" alt=""><i class="bi bi-arrow-right"></i> </div></Link>
            </div>
            <div class="col-md-4">
                <Link to="twitter"> <div class="image"> <img src= "../../../images/twitter.jpg" alt=""><i class="bi bi-arrow-right"></i></div></Link>
            </div>
        </div>
    </div>
</main>

<style>

  
main{
    margin-left: 245px;
}
  
.containerm {
    min-height: 100vh;
    overflow: hidden;
    width: 100%;
    padding: 2rem;
    display: flex;
    justify-content: center;
    align-items: center
}

.image {
    overflow: hidden;
    height: 300px;
    width: 300px;
    position: relative;
    object-fit: contain;
    cursor: pointer;
    margin: 0 15px;
    box-shadow: 0 0 25px 1px rgba(0, 0, 0, .3);
    transition: .5s;
    margin-bottom: 4rem;
    background-color: #555
}

.image:after {
    content: '';
    position: absolute;
    z-index: 1;
    top: 50%;
    left: 50%;
    width: 500px;
    height: 500px;
    transform: translate(-140%, -50%);
    background-color: #d9d9d9;
    opacity: 0.8;
    border-radius: 50%;
    transition: .8s
}

.image:hover:after {
    transform: translate(-50%, -50%)
}

.image:hover img {
    transform: translate(-50%, -50%) scale(1.3) rotate(20deg)
}

img {
    position: absolute;
    height: 105%;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    transition: .8s
}

i {
    position: absolute;
    z-index: 2;
    top: 50%;
    left: 50%;
    transform: translate(-2000px, -50%);
    color: #fff;
    transition: .8s;
    transition-timing-function: ease-in
}

.image:hover i {
    transform: translate(-50%, -50%);
    transition-timing-function: ease
}
</style>
