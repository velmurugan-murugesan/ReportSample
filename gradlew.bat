����   2w <com/velmm/velmmandroid/pushnotification/VelmmFirebaseService  6com/google/firebase/messaging/FirebaseMessagingService  
onNewToken (Ljava/lang/String;)V $Lorg/jetbrains/annotations/Nullable; /com/google/firebase/messaging/FirebaseMessaging  getInstance 3()Lcom/google/firebase/messaging/FirebaseMessaging; 
 
 	  all  subscribeToTopic 7(Ljava/lang/String;)Lcom/google/android/gms/tasks/Task;  
 	  Icom/velmm/velmmandroid/pushnotification/VelmmFirebaseService$onNewToken$1  <init> A(Lcom/velmm/velmmandroid/pushnotification/VelmmFirebaseService;)V  
   /com/google/android/gms/tasks/OnCompleteListener  !com/google/android/gms/tasks/Task  addOnCompleteListener V(Lcom/google/android/gms/tasks/OnCompleteListener;)Lcom/google/android/gms/tasks/Task;  
    *com/google/firebase/iid/FirebaseInstanceId " .()Lcom/google/firebase/iid/FirebaseInstanceId; 
 $
 # %  FirebaseInstanceId.getInstance() ' kotlin/jvm/internal/Intrinsics ) checkExpressionValueIsNotNull '(Ljava/lang/Object;Ljava/lang/String;)V + ,
 * - getInstanceId %()Lcom/google/android/gms/tasks/Task; / 0
 # 1 Icom/velmm/velmmandroid/pushnotification/VelmmFirebaseService$onNewToken$2 3 INSTANCE KLcom/velmm/velmmandroid/pushnotification/VelmmFirebaseService$onNewToken$2; 5 6	 4 7 this >Lcom/velmm/velmmandroid/pushnotification/VelmmFirebaseService; s Ljava/lang/String; onMessageReceived 0(Lcom/google/firebase/messaging/RemoteMessage;)V #Lorg/jetbrains/annotations/NotNull; remoteMessage @ checkParameterIsNotNull B ,
 * C = >
  E +com/google/firebase/messaging/RemoteMessage G getData ()Ljava/util/Map; I J
 H K getImage M >
  N -Lcom/google/firebase/messaging/RemoteMessage; sendNotification (Landroid/graphics/Bitmap;)V 4androidx/core/app/NotificationCompat$BigPictureStyle S ()V  U
 T V 
bigPicture Q(Landroid/graphics/Bitmap;)Landroidx/core/app/NotificationCompat$BigPictureStyle; X Y
 T Z android/media/RingtoneManager \ getDefaultUri (I)Landroid/net/Uri; ^ _
 ] ` 4RingtoneManager.getDefau…anager.TYPE_NOTIFICATION) b android/content/Intent d getApplicationContext ()Landroid/content/Context; f g
  h #com/velmm/velmmandroid/MainActivit