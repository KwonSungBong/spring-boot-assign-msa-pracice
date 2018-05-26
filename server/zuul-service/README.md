# auth-service

https://github.com/anthofo/spring-boot-security-oauth2-jwt

# 키생성
keytool -genkey -alias zuulServiceKey -keyalg RSA -keystore keystore.jks -storepass zuulServicePassword -dname "CN=Web Server,OU=Unit,O=Organization,L=City,S=State,C=US"

#허용
curl localhost:8095/zuul

#토큰요청
curl zuulService:zuulServiceSecret@localhost:8095/oauth/token -d grant_type=password -d username=user -d password=password

#토큰설정해서 요청
curl -H "Authorization: Bearer [access_token]" localhost:8095/user


