/*    */ package cn.huangchengxi.homepage.controller;
/*    */ 
/*    */ import cn.huangchengxi.homepage.entity.RecommendedBook;
/*    */ import cn.huangchengxi.homepage.repository.RecommendedBookRepository;
/*    */ import cn.huangchengxi.homepage.results.BookDeleteResult;
/*    */ import cn.huangchengxi.homepage.results.BookPostResult;
/*    */ import cn.huangchengxi.homepage.results.BookResult;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import javax.transaction.Transactional;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestMethod;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ public class BookController
/*    */ {
/*    */   @Autowired
/*    */   private RecommendedBookRepository bookRepository;
/*    */   
/*    */   @RequestMapping(value = {"/getBookDetail"}, method = {RequestMethod.POST})
/*    */   @ResponseBody
/*    */   public String getBookDetail(@RequestBody String json) throws Exception {
/* 32 */     JSONObject object = JSONObject.parseObject(json);
/* 33 */     Long id = object.getLong("id");
/* 34 */     RecommendedBook book = this.bookRepository.findById(id).get();
/*    */     
/* 36 */     if (book == null) {
/* 37 */       BookResult bookResult = new BookResult(false);
/* 38 */       return JSONObject.toJSONString(bookResult);
/*    */     } 
/* 40 */     BookResult result = new BookResult(true, id, book.getBookName(), book.getBookDescription(), book.getBookUrl(), book.getBookMessage());
/* 41 */     return JSONObject.toJSONString(result);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @RequestMapping(value = {"/bookManage/postBook-processing"}, method = {RequestMethod.POST})
/*    */   @ResponseBody
/*    */   @Transactional
/*    */   public String postBook(@RequestBody String jsonContent) throws Exception {
/*    */     try {
/* 53 */       new JSONObject(); JSONObject book = JSONObject.parseObject(jsonContent);
/* 54 */       String bookName = book.getString("bookName");
/* 55 */       String bookDes = book.getString("bookDescription");
/* 56 */       String bookUrl = book.getString("bookUrl");
/* 57 */       String bookMessage = book.getString("bookMessage");
/* 58 */       RecommendedBook recommendedBook = new RecommendedBook(bookName, bookDes, bookUrl, bookMessage);
/* 59 */       this.bookRepository.save(recommendedBook);
/* 60 */       BookPostResult result = new BookPostResult(true);
/* 61 */       return JSONObject.toJSONString(result);
/* 62 */     } catch (Exception e) {
/* 63 */       BookPostResult result = new BookPostResult(false);
/* 64 */       return JSONObject.toJSONString(result);
/*    */     } 
/*    */   }
/*    */   @RequestMapping(value = {"/bookManage/delete"}, method = {RequestMethod.POST})
/*    */   @ResponseBody
/*    */   @Transactional
/*    */   public String deleteBook(@RequestBody String json) {
/* 71 */     JSONObject object = JSONObject.parseObject(json);
/* 72 */     Long id = object.getLong("id");
/* 73 */     RecommendedBook book = this.bookRepository.findById(id).get();
/* 74 */     if (book == null) {
/* 75 */       BookDeleteResult bookDeleteResult = new BookDeleteResult(Boolean.valueOf(false), "书本不存在");
/* 76 */       return JSONObject.toJSONString(bookDeleteResult);
/*    */     } 
/* 78 */     this.bookRepository.delete(book);
/* 79 */     BookDeleteResult result = new BookDeleteResult(Boolean.valueOf(true), "删除成功");
/* 80 */     return JSONObject.toJSONString(result);
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\controller\BookController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */