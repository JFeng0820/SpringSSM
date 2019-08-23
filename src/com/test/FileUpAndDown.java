package com.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller

@Service("FileUpAndDown")
@Transactional
public class FileUpAndDown {
   
    @RequestMapping("/fileDownLoad")
    public ResponseEntity<byte[]> fileDownLoad(HttpServletRequest request) throws Exception{
     System.out.println("12");
      ServletContext servletContext = request.getServletContext();
      String fileName="yzm.jpg";
      String realPath = servletContext.getRealPath(fileName);//�õ��ļ�����λ��
        InputStream in=new FileInputStream(new File(realPath));//�����ļ����뵽������֮��
         byte[] body=null;
         body=new byte[in.available()];// ������һ�ζԴ����������õķ������Բ��������شӴ���������ȡ�����������Ĺ���ʣ���ֽ���
         in.read(body);//���뵽����������
        
        fileName=new String(fileName.getBytes("UTF-8"),"UTF-8");//��ֹ��������
        HttpHeaders headers=new HttpHeaders();//������Ӧͷ
        headers.add("Content-Disposition", "attachment;filename="+fileName);
        HttpStatus statusCode = HttpStatus.OK;//������Ӧ��
        ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body, headers, statusCode);
        return response;
    }
}
