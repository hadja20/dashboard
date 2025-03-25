<script>
	import { Router, Route} from "svelte-navigator";
    import Login from "./components/Auth/Login.svelte";
	import Register from "./components/Auth/Register.svelte";
    import Clock from "./components/Clock/Clock.svelte";
	import Quote from "./components/Quote/Quote.svelte";
    import Home from "./components/Home/Home.svelte";
    import Weather from "./components/Weather/Weather.svelte";
	import Twitter from "./components/Twitter/Twitter.svelte";
</script>

<Router>
		<Route path="login" primary={false} ><Login/> </Route>		
		<Route path="register" primary={false}> <Register/></Route>
		<Route path="weather" primary={false}><Weather/></Route>
		<Route path='/' primary={false}> <Home/></Route>
		<Route path="clock" primary={false}><Clock/></Route>
		<Route path="quote" primary={false}><Quote/></Route>
		<Route path="twitter" primary={false}><Twitter/></Route>
</Router>