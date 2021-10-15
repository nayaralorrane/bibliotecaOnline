package br.gov.sp.fatec.bibliotecaOnline.Security;

import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import br.gov.sp.fatec.bibliotecaOnline.Entities.RequestModels.LoginRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {
    private static final String key = "5J45$iTOzUP#qws9";

    public static String generateToken(Authentication authentication) throws JsonProcessingException{
        LoginRequest usuario = new LoginRequest();
        usuario.setEmail(authentication.getName());
        usuario.setPermissao(authentication.getAuthorities().toArray()[0].toString());

        ObjectMapper objectMapper = new ObjectMapper();
        String usuarioJson = objectMapper.writeValueAsString(usuario);
        Date dataAtual = new Date();
        Long hora = 1000L * 60L * 60L;
        return Jwts.builder().claim("userDetails", usuarioJson).setIssuer("br.gov.sp.fatec")
            .setSubject(authentication.getName()).setExpiration(new Date(dataAtual.getTime() + hora)).signWith(SignatureAlgorithm.HS512 , key).compact();

    }

    public static Authentication parseToken(String token) throws JsonParseException, JsonMappingException, IOException{
        String credentialsJson = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().get("userDetails", String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        LoginRequest credential = objectMapper.readValue(credentialsJson, LoginRequest.class);
        
        UserDetails userDetail = User.builder().username(credential.getEmail()).password("secret").authorities(credential.getPermissao()).build();
        return new UsernamePasswordAuthenticationToken(credential.getEmail(), credential.getSenha(), userDetail.getAuthorities());
    }

}
