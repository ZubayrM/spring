function newMessage(){
 let message = $('form').serialize();
 $.ajax({
   method: "POST",
   url: "/add",
   data: message
 });
}