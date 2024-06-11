package com.application.livrago.util

import android.content.Context
import android.content.Intent
import android.content.IntentSender
import com.application.livrago.R
import com.application.livrago.domain.model.SignInResult
import com.application.livrago.domain.model.User
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.BeginSignInRequest.GoogleIdTokenRequestOptions
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.Firebase
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import kotlinx.coroutines.tasks.await
import java.util.concurrent.CancellationException

class GoogleAuthUiHelper(
    private val context: Context,
    private val oneTapClient: SignInClient
) {
    private val auth = Firebase.auth

    //lancer la boite de dialoque pour l'authentification google
    suspend fun actionSignIn() : IntentSender?{
        val result = try {
            oneTapClient.beginSignIn(
                BeginSignInRequest.builder()
                    .setGoogleIdTokenRequestOptions(
                        GoogleIdTokenRequestOptions.builder()
                            .setSupported(true)
                            .setFilterByAuthorizedAccounts(false)
                            .setServerClientId(context.getString(R.string.client_id))
                            .build()
                    )
                    .setAutoSelectEnabled(true)
                    .build()
            ).await()
        }catch (e : Exception){
            e.printStackTrace()
            if(e is CancellationException) throw e
            null
        }
        return result?.pendingIntent?.intentSender
    }

    suspend fun getSignInResultFromIntentAndSignIn(intent: Intent) : SignInResult
    {
        val credential = oneTapClient.getSignInCredentialFromIntent(intent)
        val googleIdToken = credential.googleIdToken
        val googleCredential = GoogleAuthProvider.getCredential(googleIdToken,null)
        return try {
            val user = auth.signInWithCredential(googleCredential).await().user
            SignInResult(
                data = User(
                    user!!.uid,user.displayName, user.photoUrl.toString()
                ),
                errorMessage = null
            )
        }catch (e : Exception){
            e.printStackTrace()
            if(e is CancellationException) throw e
            SignInResult(null, e.message)
        }
    }
}