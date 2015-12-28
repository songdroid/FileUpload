<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title></head>
<body>
<form method="post"  action="upload.spring?ver=first" enctype="multipart/form-data">
	제목 :<input type="text" name="title"/><br/><br/>
	이름 :<input type="text" name="name"/><br/><br/>
	파일 :<input type="file" name="upFile"/><br/><br/>
	<input type="submit" value="데이터 전송" />
</form>
</body>
</html>