<style>
	.m-card {
		width: 50vw;
		border: 1px solid #aaa;
		border-radius: 4px;
		box-shadow: 4px 4px 12px rgba(0,0,0,0.4);
		padding: 1em;
		margin: auto;
		margin-bottom: 20px;
		align-items: center;
	}
</style>

<div class="m-card">
	<h2>
		<slot name="header">
			Unknown header
		</slot>
	</h2>

	<div class="footer">
		<slot name="footer">
			Unknown footer
		</slot>
	</div>
</div>