(this["webpackJsonpcms-application"]=this["webpackJsonpcms-application"]||[]).push([[0],{295:function(e,t,a){e.exports=a(520)},304:function(e,t,a){},519:function(e,t,a){},520:function(e,t,a){"use strict";a.r(t);var n,r=a(1),o=a.n(r),l=a(40),c=a.n(l),u=a(21),s=a(26),i=a(76),m=a(18),d=a(25),p=a(97),E=a(542),f=(a(304),a(543)),g=a(541),h=a(522),v=a(536),b=a(535),C=a(47);!function(e){e.LOGIN="login",e.SIGN_UP="signup",e.SET_POSTS="sp",e.ADD_POST="ap",e.DEFAULT="def",e.FETCH_POST_CATEGORIES="fpc",e.SET_ACTIVE_CATEGORY="ac",e.SET_CATEGORIES="setCategories",e.DELETE_POST="delpost",e.LOGOUT="logout",e.ADD_COMMENT="add comment",e.DELETE_COMMENT="delete commetn",e.UPDATE_POST="update post",e.SET_TITLE="set title"}(n||(n={}));var y=a(27),O=a.n(y);O.a.defaults.withCredentials=!0;var T=function(e){return function(){return O.a.get("https://localhost:8443/post").then((function(t){var a=t.data;Promise.all(a.map((function(e){return O.a.get("https://localhost:8443/post/".concat(e.id,"/comments")).then((function(t){e.comments=t.data}))}))).then((function(t){e(function(e){return{type:n.SET_POSTS,posts:e}}(a))}))}))}},S=function(e){return function(t,a,r,o){return O.a.post("https://localhost:8443/post",{title:t,description:a,category:r},{}).then((function(t){if(t.data){var a=Object(C.a)(Object(C.a)({},t.data),{},{comments:[]});a.error||e({type:n.ADD_POST,post:a})}})).then((function(e){alert("Successfully created post")})).catch((function(e){alert(e)}))}},A=function(e){return function(t,a,r,o){return O.a.patch("https://localhost:8443/post/".concat(o),{title:t,description:a,category:r}).then((function(t){if(!t.data.status||"ok"!==t.data.status)return alert(t.data.status),Promise.resolve({status:"error"});O.a.get("https://localhost:8443/post/".concat(t.data.post.id,"/comments")).then((function(a){return t.data.post.comments=a.data,e({type:n.UPDATE_POST,post:t.data.post}),alert("Post is updated successfully"),Promise.resolve({status:"ok"})}))}))}},j=function(e){return function(t){return O.a.delete("https://localhost:8443/post/"+t).then((function(a){a.data.status||alert("unknown error"),alert(a.data.status),"success"===a.data.status&&e({type:n.DELETE_POST,id:t})}))}},w=function(e){return function(t,a){return O.a.post("https://localhost:8443/post/".concat(a.id,"/comments"),{content:t}).then((function(t){var a=t.data;e({type:n.ADD_COMMENT,comment:a})}))}},P=function(e){return function(t){return O.a.delete("https://localhost:8443/post/".concat(t.post.id,"/comments/").concat(t.id)).then((function(a){"deleted"===a.data.status&&e({type:n.DELETE_COMMENT,comment:t})}))}};var k=Object(u.b)((function(e){return{user:e.user}}),(function(e){return{onDelete:P(e)}}))((function(e){return o.a.createElement(g.a,null,o.a.createElement(v.a,null,!!e.user&&("admin"===e.user.category||!!e.comment.user&&(e.comment.user.id===e.user.id||e.comment.post.author.id===e.user.id))&&o.a.createElement(v.a.Actions,null,o.a.createElement(v.a.Action,{as:h.a,onClick:function(){e.onDelete(e.comment)},size:"tiny",color:"red",floated:"right"},"X")),o.a.createElement(v.a.Content,null,o.a.createElement(v.a.Author,null,e.comment.user?e.comment.user.firstName+" "+e.comment.user.lastName:"user is not found"),o.a.createElement(v.a.Text,null,o.a.createElement("p",null,e.comment.content)))))}));var D=Object(d.g)(Object(u.b)((function(e,t){return{post:e.posts.find((function(e){return t.match.params.id==e.id})),user:e.user}}),(function(e){return{onAddComment:w(e)}}))((function(e){var t=o.a.useState(!0),a=Object(m.a)(t,2),n=a[0],r=a[1],l=o.a.useState(""),c=Object(m.a)(l,2),u=c[0],s=c[1];return e.post?o.a.createElement(E.a,{className:"postDetails",centered:!0},o.a.createElement(E.a.Row,null,o.a.createElement(E.a.Column,null,o.a.createElement(f.a,{size:"huge",textAlign:"center"},o.a.createElement(f.a.Content,null,e.post.title),o.a.createElement(f.a.Subheader,null,"Author: ",function(){var t;return e.post.author?e.post.author.id===(null===(t=e.user)||void 0===t?void 0:t.id)?"you":e.post.author.firstName+" "+e.post.author.lastName:"User no longer exists"}()),o.a.createElement(f.a.Subheader,null,"Category: ",e.post.category.value)))),o.a.createElement(E.a.Row,{stretched:!0},o.a.createElement(E.a.Column,{stretched:!0},o.a.createElement(g.a,{basic:!0,attached:"top",size:"large"},e.post.description.split("\n").map((function(e){return o.a.createElement("p",null,e)}))))),o.a.createElement(E.a.Row,null,o.a.createElement(E.a.Column,null,o.a.createElement(g.a,{inverted:!0,as:h.a,fluid:!0,onClick:function(){return r((function(e){return!e}))}},n?"Hide ":"Show ","comments"),o.a.createElement(v.a.Group,{className:"center",collapsed:!n},e.post.comments.map((function(e){return o.a.createElement(k,{key:e.id,comment:e})})),e.user&&o.a.createElement(b.a,null,o.a.createElement(b.a.TextArea,{placeholder:"Add comment...",value:u,onChange:function(e,t){s(e.currentTarget.value)}}),o.a.createElement(h.a,{content:"Add Comment",onClick:function(t){t.preventDefault(),console.log(e.post),e.onAddComment(u,e.post).then((function(){s("")}))},labelPosition:"left",icon:"edit",primary:!0})))))):o.a.createElement(o.a.Fragment,null,"Loading")}))),x=a(544),N=function(e){return function(t,a){return O.a.post("https://localhost:8443/user/login",{username:t,password:a}).then((function(t){if(console.log(t.data),!t.data)return Promise.resolve(!1);e(I(t.data))}))}},I=function(e){return{type:n.LOGIN,user:e}},L=function(e){return function(){return O.a.get("https://localhost:8443/user").then((function(t){t.data&&e(I(t.data))}))}},_=function(e){return function(){return O.a.post("https://localhost:8443/user/logout").then((function(t){!0!==t.data?alert(t.data):e({type:n.LOGOUT})}))}},M=function(e){return function(t){return O.a.post("https://localhost:8443/user/register",t).then((function(t){var a=t.data;if(console.log(t.data),a.error)return Promise.resolve({error:a.error});e(I(t.data))}))}};var R=Object(u.b)((function(e){return{user:e.user}}),(function(e){return{logout:_(e)}}))((function(e){return o.a.createElement(x.a,{className:"topMenu",borderless:!0,stackable:!0,fluid:!0,attached:"top"},o.a.createElement(x.a.Item,{as:s.b,to:"/"},"Home"),e.user&&o.a.createElement(o.a.Fragment,null,o.a.createElement(x.a.Item,{as:s.b,to:"/post"},"Posts"),o.a.createElement(x.a.Item,{as:s.b,to:"/newPost"},"New post"),"admin"===e.user.category&&o.a.createElement(x.a.Item,{as:s.b,to:"/admin"},"Admin")),o.a.createElement(x.a.Menu,{position:"right"},e.user?o.a.createElement(o.a.Fragment,null,o.a.createElement(x.a.Item,null,e.user.username),o.a.createElement(x.a.Item,null,o.a.createElement(h.a,{as:s.b,onClick:function(){e.logout()},className:"inverted",to:"/"},"Logout"))):o.a.createElement(o.a.Fragment,null,o.a.createElement(x.a.Item,null,o.a.createElement(h.a,{as:s.b,className:"inverted",to:"/login"},"Login")),o.a.createElement(x.a.Item,null,o.a.createElement(h.a,{as:s.b,className:"inverted",to:"/signup"},"Sign up")))))})),F=a(539);function U(e){return o.a.createElement(F.a,{fluid:!0,as:s.b,to:"/post/".concat(e.post.id),color:"black"},o.a.createElement(F.a.Content,null,o.a.createElement(F.a.Header,{textAlign:"center"},e.post.title),o.a.createElement(F.a.Meta,{textAlign:"center"},"Category: ",e.post.category.value),o.a.createElement(F.a.Meta,{textAlign:"center"},"Author: ",e.post.author.username)))}var G=function(e){return function(){return O.a.get("https://localhost:8443/postCategory").then((function(t){var a;e((a=t.data,{type:n.SET_CATEGORIES,categories:a}))}))}};var H=Object(u.b)((function(e){return{categories:e.postCategories,active:e.selectedCategoryId}}),(function(e){return{onClick:function(t){e(function(e){return{type:n.SET_ACTIVE_CATEGORY,category:e?e.id:0}}(t))},loadCat:G(e)}}))((function(e){return o.a.createElement(x.a,{vertical:!0,fluid:!0},o.a.createElement(x.a.Item,{className:"inverted"},"Categories"),e.categories.map((function(t){return o.a.createElement(x.a.Item,{link:!0,key:t.id,active:t.id===e.active,onClick:function(a){e.onClick(t),console.log(t)}},t.value)})))})),q=a(534),z=a(532),B=Object(u.b)((function(e){return{}}),(function(e){return{onTitleChange:function(t){e(function(e){return{type:n.SET_TITLE,title:e}}(t))}}}))((function(e){return o.a.useEffect((function(){console.log({props:e})}),[]),o.a.createElement(q.a,null,o.a.createElement(f.a,{size:"huge"}," Filter posts "),o.a.createElement(b.a,null,o.a.createElement(p.a,null,"Title"),o.a.createElement(z.a,{fluid:!0,onChange:function(t,a){e.onTitleChange(t.currentTarget.value)}})))}));var Y=Object(u.b)((function(e){return{posts:e.posts.filter((function(t){return t.title.toLowerCase().startsWith(e.title.toLowerCase())&&(!e.selectedCategoryId||t.category.id==e.selectedCategoryId)})).sort((function(e,t){return t.id-e.id}))}}))((function(e){return o.a.createElement(o.a.Fragment,null,o.a.createElement(E.a.Column,{floated:"left",width:"4"},o.a.createElement(B,null)),o.a.createElement(E.a.Column,{width:"8"},o.a.createElement(F.a.Group,{centered:!0},e.posts.map((function(e){return o.a.createElement(U,{post:e,key:e.id})})))),o.a.createElement(E.a.Column,{verticalAlign:"top",width:"4"},o.a.createElement(H,null)))})),K=a(94),V=a.n(K);var W=Object(d.g)(Object(u.b)((function(e){return{user:e.user}}),(function(e){return{login:N(e)}}))((function(e){var t=o.a.useState(""),a=Object(m.a)(t,2),n=a[0],r=a[1],l=o.a.useState(""),c=Object(m.a)(l,2),u=c[0],s=c[1];return e.user?o.a.createElement(d.a,{to:"/"}):o.a.createElement(b.a,{size:"big",method:"post"},""!==u&&o.a.createElement(p.a,{color:"red"},u),o.a.createElement(b.a.Field,null,o.a.createElement("label",null,"Username"),o.a.createElement("input",{placeholder:"Username",required:!0,onChange:function(e){r(e.target.value)}})),o.a.createElement(b.a.Field,null,o.a.createElement("label",null,"Password"),o.a.createElement("input",{type:"password",className:"password",autoComplete:"false",name:"pass",required:!0})),o.a.createElement(h.a,{className:"inverted",onClick:function(t){t.preventDefault();var a=V()("input[name=pass]").val();V()("input[name=pass]").val(""),e.login(n,a).then((function(t){!1===t?s("greska"):e.history.push("/")}))}},"Login"))}))),J=a(538),X=a(545);var $=Object(u.b)((function(e){return{user:e.user,posts:e.posts.filter((function(t){return e.user&&("admin"===e.user.category||t.author&&t.author.id===e.user.id)}))}}),(function(e){return{onDelete:j(e)}}))((function(e){var t=o.a.useState(1),a=Object(m.a)(t,2),n=a[0],r=a[1],l=o.a.useState(e.posts),c=Object(m.a)(l,2),u=c[0],i=c[1],p=o.a.useState(void 0),E=Object(m.a)(p,2),v=E[0],b=E[1],C=o.a.useState(null),y=Object(m.a)(C,2),O=y[0],T=y[1],S=o.a.useState(void 0),A=Object(m.a)(S,2),j=A[0];if(A[1],o.a.useEffect((function(){V.a.ajax({url:"https://breakingbadapi.com/api/quote/random",dataType:"jsonp",success:function(e){console.log("Success"),console.log(e)},error:function(e){console.log("errpr"),console.log(e)}}).then((function(e){console.log("success"),console.log(e)})).catch((function(e){console.log("catch"),console.log(e)}))}),[]),o.a.useEffect((function(){i(e.posts)}),[e.posts]),!e.user)return o.a.createElement(d.a,{to:"/login"});var w=function(t){if(t!==O){if(T(t),b("ascending"),"title"===t)return void i(e.posts.sort((function(e,t){return e.title.toLowerCase()>t.title.toLowerCase()?1:-1})));if("comm"===t)return void i(e.posts.sort((function(e,t){return e.comments.length-t.comments.length})));if("author"===t)return void i(e.posts.sort((function(t,a){var n;return t.author.id===(null===(n=e.user)||void 0===n?void 0:n.id)||t.author.username>a.author.username?1:-1})));"category"===t&&i(e.posts.sort((function(e,t){return e.category.value>t.category.value?1:-1})))}else i(u.reverse()),b("descending"===v?"ascending":"descending")};return o.a.createElement(q.a,{fluid:!0},o.a.createElement(f.a,{as:"h1"},"Your posts"),o.a.createElement(J.a,{sortable:!0},o.a.createElement(J.a.Header,null,o.a.createElement(J.a.Row,null,o.a.createElement(J.a.HeaderCell,null,"No."),o.a.createElement(J.a.HeaderCell,{sorted:"title"===O?v:void 0,onClick:function(){w("title")}},"Title"),o.a.createElement(J.a.HeaderCell,{sorted:"comm"===O?v:void 0,onClick:function(){w("comm")}},"No. of comments"),e.user&&"admin"===e.user.category&&o.a.createElement(J.a.HeaderCell,{onClick:function(){w("author")},sorted:"author"===O?v:void 0},"Author"),o.a.createElement(J.a.HeaderCell,{sorted:"category"===O?v:void 0,onClick:function(){w("category")}},"Category"),o.a.createElement(J.a.HeaderCell,null,"Details"),o.a.createElement(J.a.HeaderCell,null,"Modify"),o.a.createElement(J.a.HeaderCell,null,"Delete"))),o.a.createElement(J.a.Body,null,u.slice(5*(n-1),5*n).map((function(t,a){var r,l;return o.a.createElement(J.a.Row,{key:t.id},o.a.createElement(J.a.Cell,null,5*(n-1)+a+1),o.a.createElement(J.a.Cell,null,t.title),o.a.createElement(J.a.Cell,null,t.comments?t.comments.length:0),e.user&&"admin"===e.user.category?o.a.createElement(J.a.Cell,null,t.author&&t.author.id===(null===(r=e.user)||void 0===r?void 0:r.id)?"You":(null===(l=t.author)||void 0===l?void 0:l.username)||"not found"):null,o.a.createElement(J.a.Cell,null,t.category.value),o.a.createElement(J.a.Cell,null,o.a.createElement(s.b,{to:"/post/".concat(t.id)},"Details")),o.a.createElement(J.a.Cell,null,o.a.createElement(s.b,{to:"/update/".concat(t.id)}," Modify")),o.a.createElement(J.a.Cell,null,o.a.createElement(h.a,{onClick:function(a,n){console.log("delete"),e.onDelete(t.id)},color:"red"},"Delete")))})))),o.a.createElement(X.a,{activePage:n,onPageChange:function(e,t){console.log(t),"string"===typeof t.activePage?r(parseInt(t.activePage)):r(t.activePage||1)},totalPages:Math.ceil(u.length/5)}),j&&o.a.createElement(g.a,null,o.a.createElement("p",null,j.quote),o.a.createElement("p",null,"Author:",j.author)))})),Q=a(533),Z=a(537);function ee(e){var t=o.a.useState(""),a=Object(m.a)(t,2),n=a[0],r=a[1],l=o.a.useState(""),c=Object(m.a)(l,2),u=c[0],s=c[1],i=o.a.useState(void 0),p=Object(m.a)(i,2),E=p[0],g=p[1];return o.a.useEffect((function(){e.post&&(r(e.post.title),s(e.post.description),g(e.post.category))}),[e.post]),e.user?o.a.createElement(q.a,{fluid:!0},o.a.createElement(f.a,{as:"h2"},"Add new post"),o.a.createElement(b.a,{size:"big"},o.a.createElement(b.a.Input,{className:"postTitle",labelPosition:"left corner",value:n,onChange:function(e,t){r(e.currentTarget.value)},label:"Title"}),o.a.createElement(Q.a,{placeholder:"Content...",value:u,onChange:function(e,t){s(e.currentTarget.value)}}),o.a.createElement(Z.a,{selection:!0,value:E&&E.id,fluid:!0,placeholder:"category",options:e.categories.map((function(e,t){return{key:e.id,text:e.value,active:e===E,selected:e===E,value:e.id}})),onChange:function(t,a){g(e.categories.find((function(e){return e.id===a.value})))}}),o.a.createElement(h.a,{disabled:!E||""===n,className:"inverted",onClick:function(){var t;console.log("kliknuto"),E?e.onClick(n,u,E,null===(t=e.post)||void 0===t?void 0:t.id):alert("Please insert the category")}},e.post?"Modify post":"Add post"))):o.a.createElement(d.a,{to:"/login"})}var te=Object(u.b)((function(e){return{user:e.user,categories:e.postCategories}}),(function(e){return{onClick:S(e)}}))(ee),ae=Object(d.g)(Object(u.b)((function(e,t){return console.log({routeProps:t}),{user:e.user,categories:e.postCategories,post:e.posts.find((function(e){return e.id==t.match.params.id}))}}),(function(e){return{onClick:A(e)}}))(ee)),ne=a(39);var re=function(e){var t=Math.PI/180,a=e.cx,n=e.cy,r=e.midAngle,l=e.innerRadius,c=e.outerRadius,u=e.startAngle,s=e.endAngle,i=e.fill,m=e.payload,d=e.percent,p=e.value,E=Math.sin(-t*r),f=Math.cos(-t*r),g=a+(c+10)*f,h=n+(c+10)*E,v=a+(c+30)*f,b=n+(c+30)*E,C=v+22*(f>=0?1:-1),y=b,O=f>=0?"start":"end";return o.a.createElement("g",null,o.a.createElement("text",{x:a,y:n,dy:8,textAnchor:"middle",fill:i},m.name),o.a.createElement(ne.g,{cx:a,cy:n,innerRadius:l,outerRadius:c,startAngle:u,endAngle:s,fill:i}),o.a.createElement(ne.g,{cx:a,cy:n,startAngle:u,endAngle:s,innerRadius:c+6,outerRadius:c+10,fill:i}),o.a.createElement("path",{d:"M".concat(g,",").concat(h,"L").concat(v,",").concat(b,"L").concat(C,",").concat(y),stroke:i,fill:"none"}),o.a.createElement("circle",{cx:C,cy:y,r:2,fill:i,stroke:"none"}),o.a.createElement("text",{x:C+12*(f>=0?1:-1),y:y,textAnchor:O,fill:"#333"},"".concat(p," post").concat(p>1?"s":"")),o.a.createElement("text",{x:C+12*(f>=0?1:-1),y:y,dy:18,textAnchor:O,fill:"#999"},"(".concat((100*d).toFixed(2),"%)")))},oe=Object(u.b)((function(e){return{posts:e.posts,user:e.user}}))((function(e){var t=o.a.useState(0),a=Object(m.a)(t,2),n=a[0],r=a[1],l=o.a.useState(0),c=Object(m.a)(l,2),u=c[0],s=c[1],i=o.a.useState([]),p=Object(m.a)(i,2),E=p[0],f=p[1];return o.a.useEffect((function(){O.a.get("https://localhost:5000/user").then((function(e){console.log({users:e.data}),f(e.data)}))}),[]),e.user&&"user"!==e.user.category?o.a.createElement(q.a,{fluid:!0},o.a.createElement(ne.f,{width:500,height:500,compact:!0,className:"whiteBackground"},o.a.createElement(ne.e,{activeIndex:n,onMouseEnter:function(e,t){r(t)},onMouseDown:function(e,t){s(t)},activeShape:re,data:E.map((function(t){return{name:t.username,value:(a=t,e.posts.filter((function(e){return e.author.id===a.id})).length)};var a})),cx:200,cy:200,innerRadius:60,outerRadius:80,fill:"#8884d8",dataKey:"value"})),o.a.createElement(ne.b,{className:"whiteBackground",compact:!0,width:600,height:500,data:E.length?e.posts.filter((function(e){return e.author.id===E[u].id})).map((function(e){return{post:e.title.length>8?e.title.substr(0,8)+"...":e.title,value:e.comments.length}})):[]},o.a.createElement(ne.i,{name:"posts",dataKey:"post"},o.a.createElement(ne.d,{value:E.length?"".concat(E[u].username,"'s posts"):"Loading",offset:0,position:"insideBottom"})),o.a.createElement(ne.j,{label:{value:"Number of comments",angle:-90,position:"insideLeft",fontSize:14},minTickGap:1}),o.a.createElement(ne.h,null),o.a.createElement(ne.c,{stroke:"#f5f5f5"}),o.a.createElement(ne.a,{dataKey:"value",fill:"#82ca9d"}))):o.a.createElement(d.a,{to:"/login"})}));var le=Object(d.g)(Object(u.b)((function(e){return{user:e.user}}),(function(e){return{onSubmit:M(e)}}))((function(e){var t=o.a.useState(""),a=Object(m.a)(t,2),n=a[0],r=a[1],l=o.a.useState(""),c=Object(m.a)(l,2),u=c[0],s=c[1],i=o.a.useState(""),E=Object(m.a)(i,2),f=E[0],g=E[1],v=o.a.useState(""),C=Object(m.a)(v,2),y=C[0],O=C[1],T=o.a.useState(""),S=Object(m.a)(T,2),A=S[0],j=S[1],w=o.a.useState(void 0),P=Object(m.a)(w,2),k=P[0],D=P[1],x=o.a.useState(""),N=Object(m.a)(x,2),I=N[0],L=N[1];return e.user?o.a.createElement(d.a,{to:"/"}):o.a.createElement(b.a,{size:"big",onSubmit:function(t,a){t.preventDefault(),u===f?""!==n?""!==u?""!==y?""!==A?k?e.onSubmit({age:k,firstName:y,lastName:A,password:u,username:n}).then((function(t){t&&t.error?L(t.error):e.history.push("/")})):L("Age is required"):L("lastname is required"):L("firstname is required"):L("password is required"):L("Username is required"):L("Passwords don't match")}},""!==I&&o.a.createElement(p.a,{color:"red"},I),o.a.createElement(b.a.Field,null,o.a.createElement("label",null,"Username"),o.a.createElement("input",{placeholder:"Username",value:n,onChange:function(e){r(e.target.value)}})),o.a.createElement(b.a.Field,null,o.a.createElement("label",null,"Password"),o.a.createElement("input",{type:"password",value:u,onChange:function(e){s(e.target.value)}})),o.a.createElement(b.a.Field,null,o.a.createElement("label",null,"Repeat password"),o.a.createElement("input",{type:"password",value:f,onChange:function(e){g(e.target.value)}})),o.a.createElement(b.a.Field,null,o.a.createElement("label",null,"First name"),o.a.createElement("input",{type:"text",value:y,onChange:function(e){O(e.target.value)}})),o.a.createElement(b.a.Field,null,o.a.createElement("label",null,"Last name"),o.a.createElement("input",{type:"text",value:A,onChange:function(e){j(e.target.value)}})),o.a.createElement(b.a.Field,null,o.a.createElement("label",null,"Age"),o.a.createElement("input",{type:"number",value:k,onChange:function(e){D(parseInt(e.target.value))}})),o.a.createElement(h.a,{className:"inverted"},"Sign up"))})));var ce=Object(u.b)((function(e){return{}}),(function(e){return{loadPosts:T(e),findUser:L(e),loadCat:G(e)}}))((function(e){var t=o.a.useState(!0),a=Object(m.a)(t,2),n=a[0],r=a[1];return o.a.useEffect((function(){console.log("pre"),e.loadPosts(),e.loadCat(),e.findUser().then((function(e){console.log("end"),r(!1)}))}),[]),n?o.a.createElement(o.a.Fragment,null,o.a.createElement(p.a,null,"Loading...")):o.a.createElement(E.a,{padded:"horizontally",columns:"16",className:"body"},o.a.createElement(E.a.Row,{className:"firstRow"},o.a.createElement(R,null)),o.a.createElement(E.a.Row,{centered:!0,className:"secondRow"},o.a.createElement(d.d,null,o.a.createElement(d.b,{exact:!0,path:"/"},o.a.createElement(Y,null)),o.a.createElement(d.b,{exact:!0,path:"/index.html"},o.a.createElement(d.a,{to:"/"})),o.a.createElement(d.b,{exact:!0,path:"/post"},o.a.createElement($,null)),o.a.createElement(d.b,{path:"/post/:id"},o.a.createElement(D,null)),o.a.createElement(d.b,{exact:!0,path:"/admin"},o.a.createElement(oe,null)),o.a.createElement(d.b,{exact:!0,path:"/newPost"},o.a.createElement(te,null)),o.a.createElement(d.b,{exact:!0,path:"/update/:id"},o.a.createElement(ae,null)),o.a.createElement(d.b,{exact:!0,path:"/login"},o.a.createElement(W,null)),o.a.createElement(d.b,{exact:!0,path:"/signup"},o.a.createElement(le,null)),o.a.createElement(d.b,{to:"/"},"Path does not exist"))))})),ue=(a(519),a(96)),se=Object(i.b)({posts:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:[],t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{type:n.DEFAULT};switch(t.type){case n.ADD_POST:return[].concat(Object(ue.a)(e),[t.post]);case n.SET_POSTS:return t.posts;case n.UPDATE_POST:return e.map((function(e){return e.id!==t.post.id?e:t.post}));case n.DELETE_POST:return e.filter((function(e){return e.id!==t.id}));case n.ADD_COMMENT:return e.map((function(e){return e.id===t.comment.post.id?Object(C.a)(Object(C.a)({},e),{},{comments:[].concat(Object(ue.a)(e.comments),[Object(C.a)(Object(C.a)({},t.comment),{},{post:e})])}):e}));case n.DELETE_COMMENT:return e.map((function(e){return e.id===t.comment.post.id?Object(C.a)(Object(C.a)({},e),{},{comments:e.comments.filter((function(e){return e.id!==t.comment.id}))}):e}));default:return e}},postCategories:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:[],t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{type:n.DEFAULT};switch(t.type){case n.FETCH_POST_CATEGORIES:return[].concat(Object(ue.a)(e),[t.categories]);case n.SET_CATEGORIES:return t.categories}return e},selectedCategoryId:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:0,t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{type:n.DEFAULT};switch(t.type){case n.SET_ACTIVE_CATEGORY:return t.category===e?0:t.category;default:return e}},user:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:null,t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{type:n.DEFAULT};switch(t.type){case n.LOGIN:return t.user;case n.LOGOUT:return null;default:return e}},title:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:"",t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{type:n.DEFAULT};return t.type===n.SET_TITLE?t.title:e}});Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));var ie=Object(i.c)(se);c.a.render(o.a.createElement(u.a,{store:ie},o.a.createElement(s.a,null,o.a.createElement(ce,null))),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()})).catch((function(e){console.error(e.message)}))}},[[295,1,2]]]);