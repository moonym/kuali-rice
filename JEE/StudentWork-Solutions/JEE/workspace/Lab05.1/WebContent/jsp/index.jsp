<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head><title>Welcome to JavaTunes</title></head>
<body>
  <h1>Welcome to JavaTunes</h1>
  <!-- method changed to POST in previous lab -->
  <form method="POST" action="/javatunes/search">
    <%-- should trim the keyword value before searching --%>
    <input type="text" name="keyword">
    <input type="submit" value="Search">
  </form>
</body>
</html>
