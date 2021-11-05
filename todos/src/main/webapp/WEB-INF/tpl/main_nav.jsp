<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav class="container my-3">
		
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link ${page eq 'home' ? 'active' : ''}" href="/">Home</a></li>
		<li class="nav-item"><a class="nav-link ${page eq 'open' ? 'active' : ''}" href="/open">Open</a></li>
		<li class="nav-item"><a class="nav-link ${page eq 'done' ? 'active' : ''}" href="/done">Done</a></li>
		<li class="nav-item"><a class="nav-link ${page eq 'all' ? 'active' : ''}" href="/all">All</a></li>
	</ul>
	
</nav>