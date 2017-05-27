# View Query

A simple convenience library for Android views,this library only wrapper the view to make our code clean and simple.
 
 ## Usage
 
 The view-Query library is available from (jcenter)[http://bintray.com/bintray/jcenter]
 
 `compile 'com.github.tcking:viewquery:1.0'`
 
 Or U can Simply copy the ViewQuery class into your project,  and you are good to go.
 
 ## Examples
 
 the method `id()` is wrapper `findViewById()` with a cache ,after called that you can do a lot of actions in chaining call.
 
 ``` java
 
 
 $ = new ViewQuery(activity); // or new ViewQuery(rootView) when in a fragment or inflate a view
 
 $.id(R.id.btn).clicked(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         $.id(R.id.tv).text("hello ViewQuery").textColor("#FF0000");
         $.id(R.id.btn).enabled(false).text("disabled").height(80,true);
     }
 }).view().postDelayed(new Runnable() {
     @Override
     public void run() {
         Toast.makeText(getApplicationContext(),$.id(R.id.tv).text(),Toast.LENGTH_SHORT).show();
         $.id(R.id.et).focus().showInputMethod(true);
     }
 },500);

 $.id(R.id.et).edit().addTextChangedListener(new ViewQuery.TextWatcher(){
     @Override
     public void onTextChanged(CharSequence s, int start, int before, int count) {
         if (s.length() == 0) {
             $.id(R.id.tv).gone();
         } else {
             $.id(R.id.tv).text(s).visible();
             $.id(R.id.btn).enabled(true);
         }
     }
 });
         
 
 ```