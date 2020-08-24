package com.savannah.aspectjproject.aspect;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Objects;

@Aspect
public class LoginAspectJ {

    private static final String TAG = "LoginAspectJ >>>";

    // 1、应用中用到了哪些注解，放到当前的切入点进行处理（找到需要处理的切入点）
    // execution，以方法执行时作为切点，触发Aspect类
    // * *(..)) 可以处理ClickBehavior这个类所有的方法
    @Pointcut("execution(@com.savannah.aspectjproject.annotation.LoginBehavior * * (..))")
    public void methodCut() {
        Log.w(TAG, "methodCut: ");
    }


    @Around("methodCut()")
    public Object joinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.w(TAG, "joinPoint: ");
        Object pointThis = joinPoint.getThis();
        if (pointThis instanceof Context) {
            Context context = (Context) pointThis;
            if (true) {
                Log.w(TAG, "joinPoint: login");
                Toast.makeText(context, "已经登录", Toast.LENGTH_SHORT).show();
                return joinPoint.proceed();
            } else {
                Log.w(TAG, "joinPoint: not login");
                Toast.makeText(context, "未登录", Toast.LENGTH_SHORT).show();
                return null;
            }
        }
        return null;
    }
}