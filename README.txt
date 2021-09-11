I. Access the website online: https://septshop.herokuapp.com/
II. To run the website locally:
    1. Open the project(source code) and install String tool 3 from eclipse IDE market
    2. Install Java JDK verison >= 8
    3. Dowload tomcat 8.5 to run on server and import to eclipse
    4. Install Mysql sever(could using one of these softwares: XAMPP or MAMP, ZAMPP)
    5. Turn on Mysql server(Port:3306) and Apache Module(Port: 80) in one of these softwares: XAMPP or MAMP, or ZAMPP
    6. go to http://localhost/phpmyadmin/ to create a database namely "ecomercewebsite" import ecomercewebsite.sql file in Database folder
    7. Go to pom.xml file and save the file to download all the dependencies needed
    8. Go to ecomerce_website/src/main/webapp/WEB-INF/website-config-servlet.xml
    9. Replace 
    <!-- setup database Mysql connector such as host, username, pass -->
	<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
		<property name="url" value="jdbc:mysql://us-cdbr-east-04.cleardb.com/heroku_6315a2cb71f76e6?reconnect=true:3306/ecomercewebsite"></property>
		<property name="username" value="b77633c69ca86b"></property>
		<property name="password" value="db690fc5"></property>
	</bean> 
    to 
    <!-- setup database Mysql connector such as host, username, pass -->
	<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
		<property name="url" value="jdbc:mysql://localhost:3306/ecomercewebsite"></property>
		<property name="username" value="root"></property>
		<property name="password" value=""></property>
	</bean>
    10. Save website-config-servlet.xml after make modification
    11. Right click on project folder and choose "Run on server"
III. Funtionality and Description
    1. Sign up/ Sign in and Logout
    2. Display menu from MySQL db
    3. Display items
    4. Display related items 
    5. Display the product in detail
    4. Add to cart
    5. Cart management: Add, delete, update items on the cart 
    6. Search items
    7. Payment
    8. Save bills and bill details on datababase
    
